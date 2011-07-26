package org.twuni.common.config;

import java.io.IOException;
import java.util.Properties;

public class PropertiesConfiguration extends Configuration {

	private final Properties properties;

	public static Configuration load( String name ) {

		Properties properties = new Properties();
		try {
			properties.load( PropertiesConfiguration.class.getClassLoader().getResourceAsStream( String.format( "%s.properties", name ) ) );
		} catch( IOException exception ) {
			throw new RuntimeException( exception );
		}
		return new PropertiesConfiguration( properties );
	}

	public PropertiesConfiguration( Properties properties ) {
		this.properties = properties;
	}

	@Override
	public String getString( String key, String defaultValue ) {
		return properties.getProperty( key, defaultValue );
	}

	@Override
	public String getString( String key ) {
		return properties.getProperty( key );
	}

}
