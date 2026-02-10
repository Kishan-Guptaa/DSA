class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge case: if s1 is longer than s2, s2 cannot contain s1's permutation
        if (s1.length() > s2.length()) {
            return false;
        }

        // Array to store character frequency for s1 and for the current window in s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Fill the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check the first window
        if (matches(s1Freq, windowFreq)) {
            return true;
        }

        // Slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add new character to the window
            windowFreq[s2.charAt(i) - 'a']++;
            // Remove the old character from the window
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;

            // Check if the new window matches the frequency map of s1
            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    // Helper function to check if two frequency arrays match
    private boolean matches(int[] s1Freq, int[] windowFreq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != windowFreq[i]) {
                return false;
            }
        }
        return true;
    }
}