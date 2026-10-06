class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> broken = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            broken.add(ch);
        }

        int ans = 0;
        for (String w : words) {
            boolean canType = true;
            for (char ch : w.toCharArray()) {
                if (broken.contains(ch)) {
                    canType = false;
                    break;
                }
            }
            if (canType) ans++;
        }
        return ans;
    }
}