package loganconnor44.katas;

public class LongestCommonPrefix {
    /**
     * Begin by verifying that the strs array contains more than 1 element
     *  * If less than two either send an empty string or the single element that is in the strs array
     * Initialize a prefix local variable as the first strs element in the array
     * Iterate over the strs array starting with the 1-index
     * While the prefix is not an empty string continue with the following logic
     *  * If the strs element does not start with the value of prefix - reducde prefix by one character
     *  * If it does break out of the while loop and iterate over the next strs element
     * @param strs String Array
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) {
            if (strs.length == 0) {
                return "";
            } else {
                return strs[0];
            }     
        } 
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (prefix != "") {
                if (!strs[i].startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                } else {
                    break;
                }
            }
            
        }
        return prefix;
    }
}
