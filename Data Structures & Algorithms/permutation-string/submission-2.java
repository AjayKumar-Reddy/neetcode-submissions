class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int[] temp = new int[26];

        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        int i = 0, j = 0;

        while (j < s2.length()) {
            temp[s2.charAt(j) - 'a']++;

            if (j - i + 1 == s1.length()) {
                if (Arrays.equals(freq, temp)) {
                    return true;
                }

                temp[s2.charAt(i) - 'a']--;
                i++;
            }

            j++;
        }

        return false;

    }
}
