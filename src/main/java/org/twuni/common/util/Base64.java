package org.twuni.common.util;

import java.util.Arrays;

/**
 * Satisfies RFC-4648 for base-64 encoding of binary data.
 * 
 * @see <a href="http://tools.ietf.org/html/rfc4648#section-4">RFC-4648</a>
 */
public class Base64 {

	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	private static final String PADDING = "=";

	public static String encode( byte [] message, int offset, int length ) {
		return encode( Arrays.copyOfRange( message, offset, length ) );
	}

	public static String encode( byte [] message ) {

		int padding = ( 3 - ( message.length % 3 ) ) % 3;
		if( padding > 0 ) {
			message = ByteArrayUtils.padRight( message, message.length + padding );
		}

		StringBuilder buffer = new StringBuilder();

		for( int i = 0; i < message.length; i += 3 ) {

			int j = 0;

			j += ( 0xFF & message[i] ) << 16;
			j += ( 0xFF & message[i + 1] ) << 8;
			j += ( 0xFF & message[i + 2] );

			buffer.append( ALPHABET.charAt( 0x3F & ( j >> 18 ) ) );
			buffer.append( ALPHABET.charAt( 0x3F & ( j >> 12 ) ) );
			buffer.append( ALPHABET.charAt( 0x3F & ( j >> 6 ) ) );
			buffer.append( ALPHABET.charAt( 0x3F & j ) );

		}

		for( int i = 0; i < padding; i++ ) {
			buffer.replace( buffer.length() - i - 1, buffer.length() - i, PADDING );
		}

		return buffer.toString();

	}

	public static byte [] decode( String message ) {

		if( !( message.length() % 4 == 0 ) ) {
			throw new IllegalArgumentException();
		}

		byte [] decoded = createDecodingBuffer( message );
		int j = 0;

		for( int i = 0; i < message.length(); i += 4 ) {

			int [] b = {
			    ALPHABET.indexOf( message.charAt( i ) ),
			    ALPHABET.indexOf( message.charAt( i + 1 ) ),
			    ALPHABET.indexOf( message.charAt( i + 2 ) ),
			    ALPHABET.indexOf( message.charAt( i + 3 ) )
			};

			if( j < decoded.length ) {
				decoded[j++] = (byte) ( ( ( 0x3F & b[0] ) << 2 ) | ( ( 0x30 & b[1] ) >>> 4 ) );
				if( j < decoded.length ) {
					decoded[j++] = (byte) ( ( ( 0x0F & b[1] ) << 4 ) | ( ( 0x3C & b[2] ) >>> 2 ) );
					if( j < decoded.length ) {
						decoded[j++] = (byte) ( ( ( 0x03 & b[2] ) << 6 ) | ( 0x3F & b[3] ) );
					}
				}
			}

		}

		return decoded;

	}

	private static byte [] createDecodingBuffer( String message ) {

		int length = message.indexOf( PADDING );

		if( length < 0 ) {
			length = message.length();
		}

		length *= 3;
		length /= 4;

		return new byte [length];

	}

}
