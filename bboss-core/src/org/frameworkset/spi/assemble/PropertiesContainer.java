package org.frameworkset.spi.assemble;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.frameworkset.util.io.ClassPathResource;

public class PropertiesContainer {
    protected List<String> configPropertiesFiles;
    protected Properties allProperties ;
    private static Logger log = Logger.getLogger(PropertiesContainer.class);
    public void addConfigPropertiesFile(String configPropertiesFile,LinkConfigFile linkfile)
    {
    	if(configPropertiesFiles == null)
    	{
    		configPropertiesFiles = new ArrayList<String>();
    		
    	}
    	if(allProperties  == null)
    		allProperties = new Properties();
    	this.configPropertiesFiles.add(configPropertiesFile);
    	evalfile(configPropertiesFile);
    	if(linkfile != null)
    		loopback(linkfile);
    	
    }
    private void loopback(LinkConfigFile linkfile)
    {
    	linkfile.loopback(this);
    }
    private void evalfile(String configPropertiesFile)
    {
    	Properties properties = new java.util.Properties();
    	
    	InputStream input = null;
    	try
    	{
    		
    		if(!configPropertiesFile.startsWith("file:"))
    		{
		    	ClassPathResource  resource = new ClassPathResource(configPropertiesFile);
		    	input = resource.getInputStream();
		    	log.debug("load config Properties File :"+resource.getFile().getAbsolutePath());
    		}
    		else
    		{
    			String _configPropertiesFile = configPropertiesFile.substring("file:".length());
    			input = new FileInputStream(new File(_configPropertiesFile));
    			log.debug("load config Properties File :"+_configPropertiesFile);
    		}
	    	properties.load(input);
	    	allProperties.putAll(properties);
	    
    	}
    	catch(Exception e)
    	{
    		log.error("load config Properties File failed:",e);
    	}
    	finally
    	{
    		if(input != null)
				try {
					input.close();
				} catch (IOException e) {
					 
				}
    	}
    }
    
    public void mergeParentConfigProperties(PropertiesContainer parent)
    {
    	if(parent == this)
    		return;
    	if(allProperties  == null)
    		allProperties = new Properties();
    	allProperties.putAll(parent.getAllProperties());
    }
    private Map<? extends Object, ? extends Object> getAllProperties() {
		// TODO Auto-generated method stub
		return this.allProperties;
	}
	public String getProperty(String property)
    {
    	if(allProperties == null)
    		return null;
    	return allProperties.getProperty(property);
    }
    
    public int size()
    {
    	if(allProperties == null)
    		return 0;
    	return allProperties.size();
    }
    
    public static void main(String[] args)
    {
    	String _configPropertiesFile = "file:/opt/local/xxx.propertis".substring("file:".length());
    	System.out.println(_configPropertiesFile);
    }

}
