package org.twuni.common.config;

public abstract class Configuration {

	public abstract String getString( String key );

	public abstract String getString( String key, String defaultValue );

	public double getDouble( String key ) {
		return Double.parseDouble( getString( key ) );
	}

	public double getDouble( String key, double defaultValue ) {
		return Double.parseDouble( getString( key, Double.toString( defaultValue ) ) );
	}

	public float getFloat( String key ) {
		return Float.parseFloat( getString( key ) );
	}

	public float getFloat( String key, float defaultValue ) {
		return Float.parseFloat( getString( key, Float.toString( defaultValue ) ) );
	}

	public long getLong( String key ) {
		return Long.parseLong( getString( key ) );
	}

	public long getLong( String key, long defaultValue ) {
		return Long.parseLong( getString( key, Long.toString( defaultValue ) ) );
	}

	public int getInt( String key ) {
		return Integer.parseInt( getString( key ) );
	}

	public int getInt( String key, int defaultValue ) {
		return Integer.parseInt( getString( key, Integer.toString( defaultValue ) ) );
	}

	public short getShort( String key ) {
		return Short.parseShort( getString( key ) );
	}

	public short getShort( String key, short defaultValue ) {
		return Short.parseShort( getString( key, Short.toString( defaultValue ) ) );
	}

	public char getChar( String key ) {
		return getString( key ).charAt( 0 );
	}

	public char getChar( String key, char defaultValue ) {
		return getString( key, String.valueOf( defaultValue ) ).charAt( 0 );
	}

	public byte getByte( String key ) {
		return Byte.parseByte( getString( key ) );
	}

	public byte getByte( String key, byte defaultValue ) {
		return Byte.parseByte( getString( key, Byte.toString( defaultValue ) ) );
	}

	public boolean getBoolean( String key ) {
		return Boolean.parseBoolean( getString( key ) );
	}

	public boolean getBoolean( String key, boolean defaultValue ) {
		return Boolean.parseBoolean( getString( key, Boolean.toString( defaultValue ) ) );
	}

}
