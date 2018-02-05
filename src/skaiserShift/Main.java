package skaiserShift;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * Advanced Java Weekly Challenge 2
 * Encrypt and Decrypt the Contents of a Text File
 *
 * version 1.1 February 1, 2018
 *
 * @package skaiserShit
 * @author Sam Kaiser
 *
 * This package can read the data
 * from one text file and record
 * that data to another file as a
 * ciphered version of the data's
 * original value.
 *
 * It involves two files: a plain text file and
 * an encoded text file.
 *
 * The data on the plainText.txt file is recorded
 * as plainText and run through a function called
 * writeEncodedMessage().
 *
 * The function turns the data from the file into
 * an array of characters and shifts each character
 * up one spot by it's ordinal value and adds the new
 * character to the return string.
 *
 * The encoded string is then written to
 * the encodedFile.txt file to be read from.
 *
 * The string is then decoded and printed.
 *
 */


public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File plainFile = new File("plainText.txt");
        Scanner plainReader = new Scanner(plainFile);

        File encodedFile = new File("encodedText.txt");
        Scanner encodedReader = (new Scanner(encodedFile));

        String plainText = "";

        while (plainReader.hasNext()) {
            plainText += plainReader.nextLine();
        }


        String encoded = writeEncodedMessage(plainText);

        while (encodedReader.hasNext()) {
            encoded += encodedReader.nextLine();
        }


        (new FileWriter("encodedText.txt")).write(encoded + "\n");



        System.out.println("The encoded text was: " + encoded);

        String decoded = decodeMessage(encoded);
        System.out.println("The decoded text is: " + decoded);
    }


    /**writeEncodedMessage
     * @param message
     * @author Sam Kaiser
     */


    public static String writeEncodedMessage(String message) throws FileNotFoundException, IOException {

        char newVal;
        message = message;
        int intVal;
        char[] characters = message.toCharArray();

        message = "";

        for (int c = 0; c <= characters.length - 1; c++) {

            intVal = (int) characters[c];
            intVal += 1;
            newVal = (char) intVal;

            characters[c] = newVal;

        }

        message = String.valueOf(characters);


        return message;
    }


    public static String decodeMessage(String message) throws FileNotFoundException {


        char newVal;

        int intVal;
        char[] characters = message.toCharArray();

        message = "";

        for (int c = 0; c <= characters.length - 1; c++) {

            intVal = (int) characters[c];
            intVal -= 1;
            newVal = (char) intVal;

            characters[c] = newVal;

            //System.out.println(asCharacters[c]);


        }

        message = String.valueOf(characters);


        return message;

    }
}