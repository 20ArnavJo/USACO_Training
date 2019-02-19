package main;

import java.util.*;


public class Decrypty {

    public static void main(String[] args) {

        String[] arrayOfHexMessages = new String[13];
        arrayOfHexMessages[0] = "03444f3f8056ac713d5618e91b2f2dfaa3f1c12057a9d994f8c788780dff72c5a86fe01310baff47f76a4503c544436f908b523f211442b84432af7c1bd29f84e7c7c4cc37f5a1b05e25ee4c669a44aa2730855bda6fb67bf3c9c07dbc6d25a566b25a3007ccfefc9395433ae571b056d453f0bd6caf1ccd1010ee4d162abb22a3c9366cdfa2b8f2e5da7c138c";
        arrayOfHexMessages[1] = "04471d289d5fe96474530aee1b2668beb5e9cb6e55a3d9d1eb82dc7258e23ceebf78e55a1ab7fe47f67f5e15ce471773d6ce3a1a37464ab84c3cb42f73d88f99f48ed6d77effa7f37a35f84a77d655b16267905f9f70a570a785d570f3743fe52ae8121d42d8f4fb8c841061ad6fba4a9c04e5a629fb1b880f0caf5b507ebb2ef0a73d64caabb3a5a5936011c73ccbed74c673a6d89a86a44b";
        arrayOfHexMessages[2] = "0e544f25864ea167685259fb552a2dd6a3eec92110a7d3d3fdd7dc7159b668cebf63f65a14b7f30be17a1707df57526acedf6976265b04b24031b62f73c49988e0c2c4cc3bbcacbc5f3deb4766df54e22a799c0ccb6ce07db2d5d56aa17a76e866ae5b3b438ae4e1c087023ef938ba4ad447febb20bf53821608fd41587eb229a3e62173d5b4f8";
        arrayOfHexMessages[3] = "0d4e4f7c9d53ba227b4e0ce84f262df2a7fec77f1ce6f5d1fdcd897c48e53cd5b57fe31206f6f202e86e1700d94c5a27fdc373243d5a08f95d2fbb6655c499cbfac881d772eea0b6417eaa7c71d35ea562539945cd6cae39a085c07ba57635ec6ae67a3055cbf4e285924329ff77a55bd450f9ab6c9e01940e1de1405e37b229a3c53c60c8e3b2b7ecc33314cc3f84b968cb36eed2909bb245893d89ec357494f6d58ecf5c0504ba7e125641b2c2b3";
        arrayOfHexMessages[4] = "004f522b9c54ae2255440bf94e2268ede6ffc7785ca29dd5eccd937d5dfa75d5b22af70f11beba06e97f4d0fc5441777d6d2693f315548f94f38bb7b488dcb83f08ed6de64bcbbbb573eaa5a67d444e2367fd14fd366a170f3d1c97af36c22e824aa572607c5f1aeab880d2aad59a6599145e2ee2da853850a0faf525f38a72fa3eb3263d5b1f8f2dcc07a13c56b9fee738321a7d79b86b649c83b88ec217497eac5988a4c4d08ee381a565cac87fbb2bf9fa42faa136474a742559992e6e4";
        arrayOfHexMessages[5] = "1f49587c8653b176750115fb59217fbeb1fddb2d44a99dd0eac8997159b668cebf2ad70e0bbbea0fe5725e07c503556ecccf697a72554ab0443cb67c1bd5838ae18ed6da65f9efa05333f84c669a44ad62518349cc2de049bad1c93fa77733a92ea35e2507c5f1aea1950b28e379f44dd456f0ba38b716c14314ea145b3fbd26e4e23721ceacf6a1ead26118823f83fc718332b9c087d4a40b8c7386a53a79c4f6c8998a5a4c1faa2d5d";
        arrayOfHexMessages[6] = "1f49587cb648ac767c4f59d84e2261beaefdcc2d52a3dac1e18e89605ff973d2b364e35a11a4f517f73e5608cf035b62c8ce763f3c5304ae4831b67c1581bc82e1c681d77eefefb15322ef096adb5ea6313cd164da71a36bbfc0d23fa46d33fa32aa573107deffebc0831621e138a751d450f9ab6cbc01821612eb14572df32feaf47372dfb5b3bcfddb3311c32984eb32";
        arrayOfHexMessages[7] = "0048533bd57ea06d70441dff486e62f8e6c8c07f51a5d894e7cf983059e47dcfb46fe05a1abfe947e97f4503d80343689ece7b22725c51b44833fa6957c49883bb8ee0cc37ecaea14670e54f22d259b16275984bd777a83ebfc4c370a13376c123b451204bcfe4ae8684076df970b61e9f4dffa96caf1ccd1714ea145e31a134e6f47360d4a7f6b1e8c36708d02e8fb968cb36eecc9f86a016c6";
        arrayOfHexMessages[8] = "0a521d349c49e96c744f0df21b226cfca9ee842d58a39dc7e0db9b7859b668cebf2ac61f1ea2ba08e23e7f0fdb53586bc7df7b78727e4bac5b33bf7652cf8ccbe1c181eb7ff9a2ba4133f850639610aa27308643d123a87ba185c77ea57023fb66a4472107c3f9ae9489066de876a04b9d4af6ee2fb41d8b160fe65b5872f30feaf7236ed6baa2b3a9c4720e822082f570c637e0";
        arrayOfHexMessages[9] = "6b64482e8c49bd6a78540aba4c2f7ebea8f3dc2d43a7c9ddfcc8957549b67dc8be2af61f03a3ff14f07b5346df4b5227fdca6e223e5104b64f7d9d6a49d88485b5cfd29f63f4aaf34635e45d6a9a5ca3207f83029f41b56af3e2c46daa7038a925a94739438ae0e7858d076df970a15b9104e2a625be1f891050af405e2cb622a3f42364dbb1a5f2e8dd775dd62399fc79833babcd9391b116c6";
        arrayOfHexMessages[10] = "03444f3f8056ac7131011ff355277ef6a3f8887a59b2d594e7c78f3059f37286b66be61500a5b647f37f4446c84b5266cace7e763347049c5c2fa37c4fc98e9ee68ec7da7be8efbb5770f84c61df59b42774d144da6fb03ebccb816bbb7a76fa23a55d3b438af6e084c11725e838b5579250f9e06c931a9e4312ea43162ab234e8bd7367d3adb2f2fddb765de52487fd79cd738fd18e98a016c83c8bec227d81a2e899d948401fa73a164908";
        arrayOfHexMessages[11] = "0a01513d864ee963734559fc52206cf2e6f0c96f5fb49dd2e0dcdc5848e47fd3b66ff75a05b7e947f0765246c8424773cbd97f763d52049a4c2fb86a49d498c5b5fac9da37afefbb5731ee4c669a58ad377e950cd876a16cb7c0c53fa77733a921a74630548af8e8c0950b28ad4dbd5a9156e6a13eb717cd0212eb147e3ba124f6eb36729ab0a3b0edc67619823f83fc3cc73ca98f";

        String secretMessageHex = "0a551d309a54ae2271400aee176e74f1b3bcc06c46a39ddceacf8e740de274c3fa7ee51617a5ba08e23e7f03d940426bdbd83476065c41f94f31bb681bc898d1b5e2c8dd65fdbdaa123fec0952c955b7267fdc6dcf6cac72bcc1ce6da66c";
        String secretMessage = hexToString(secretMessageHex);
        String[] arrayOfASCIIEncMessages = hexToString(arrayOfHexMessages); // converting all the hex to ASCII
        StringXORer stringXORer = new StringXORer();
        HashMap<Integer, String> finalKeyNonHex = new HashMap<>();
        Set<Integer> knownKeyPositiosn = new TreeSet<>();
        String[] finalKey = new String[100];


        for (int i = 0; i < arrayOfASCIIEncMessages.length; i++) {
            HashMap<Integer, Integer> counter = new HashMap();
            ArrayList<Integer> knownSpaceIndex = new ArrayList();

            for (int j = 0; j < arrayOfASCIIEncMessages.length; j++) {
                if (!(i == j)) { //we cannot be testing a cipher against itself

                    String xorResult = stringXORer.encode(arrayOfASCIIEncMessages[i], arrayOfASCIIEncMessages[j]);

                    for (int k = 0; k < xorResult.length(); k++) {

                        //now we check if the result is an ASCII character
                        if (isCharASCIIAlphabet(String.valueOf(xorResult.charAt(k)))) {
                            if (!counter.containsKey(k)) {
                                counter.put(k, 1);
                            } else {
                                counter.put(k, counter.get(k) + 1);
                            }
                        }

                    }
                }
            }

            Iterator it = counter.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                //if the count is likely above 6 then we can say this is probably the right character for the key
                if ((Integer) pair.getValue() > 6) {
                    knownSpaceIndex.add((Integer) pair.getKey());
                }
            }

            //if we xor string with spaces we can then output the key
            String xorWithSpaces = stringXORer.encode(arrayOfASCIIEncMessages[i], generateSpaceString(arrayOfASCIIEncMessages[i]));
            for (int l : knownSpaceIndex) {
                finalKeyNonHex.put(l, String.valueOf(xorWithSpaces.charAt(l)));
                finalKey[l] = String.valueOf(xorWithSpaces.charAt(l));
                knownKeyPositiosn.add(l);

            }
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int s = 0;

        for (int m = 0; m < finalKey.length; m++) {
            if (finalKey[m] != null) {
                sb1.append(finalKey[m]);
                sb2.append(finalKey[m]);
            } else {
                sb1.append("*");
                sb2.append((char) s);
            }
        }

        String manualKeyGuess = "it takes a great deal of bravery to stand up to our enemies but just as much to stand up to our friends";

        manualKeyGuess.replace("*", String.valueOf((char) s));

        System.out.println("key is : " + sb1.toString());
        for (int i = 0; i < arrayOfASCIIEncMessages.length; i++) {
            System.out.println("Message " + i + " is: " + createSplitStringArray(arrayOfASCIIEncMessages[i], manualKeyGuess));
        }


        //System.out.println("message is : " + createSplitStringArray(arrayOfASCIIEncMessages[4],manualKeyGuess));


    }

    public static String createSplitStringArray(String inputString, String key) {
        int kLength = key.length();
        int sLength = inputString.length();
        boolean exact = false;
        String[] splitStrings;
        String[] splitStringsDecoded;
        StringXORer xoRer = new StringXORer();
        StringBuilder sb = new StringBuilder();

        if (sLength % kLength == 0) {
            splitStrings = new String[sLength / kLength];
            splitStringsDecoded = new String[sLength / kLength];
        } else {
            splitStrings = new String[(sLength / kLength) + 1];
            splitStringsDecoded = new String[(sLength / kLength) + 1];

        }

        for (int i = 0; i < splitStrings.length; i++) {
            if ((i * kLength) + kLength - 1 < inputString.length()) {
                splitStrings[i] = inputString.substring(i * kLength, (i * kLength) + kLength);
            } else {
                splitStrings[i] = inputString.substring(i * kLength, inputString.length() - 1);
            }

        }

        for (int j = 0; j < splitStringsDecoded.length; j++) {

            splitStringsDecoded[j] = xoRer.encode(splitStrings[j], key);
        }

        for (String s : splitStringsDecoded) {
            sb.append(s);
        }


        return sb.toString();
    }

    public static String[] hexToString(String[] hexStrings) {
        StringXORer stringXORer = new StringXORer();
        String[] asciiiString = new String[hexStrings.length];

        for (int i = 0; i < hexStrings.length; i++) {
            asciiiString[i] = stringXORer.convertHexToString(hexStrings[i]);
        }
        return asciiiString;
    }

    public static String hexToString(String hexString) {
        StringXORer stringXORer = new StringXORer();
        return stringXORer.convertHexToString(hexString);
    }

    public static boolean isCharASCIIAlphabet(String s) {

        return s.matches("[a-zA-Z]");
    }

    public static String generateSpaceString(String s) {
        String retString = "";

        for (int i = 0; i < s.length(); i++) {
            retString = retString + " ";
        }
        return retString;

    }


}

