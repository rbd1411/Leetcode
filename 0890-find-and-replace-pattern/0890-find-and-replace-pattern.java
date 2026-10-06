class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> list = new ArrayList<>();
        int n = pattern.length();

        for (int i = 0; i < words.length; i++) {

            char[] freq = new char[26];
            HashSet<Character> set = new HashSet<>();
            
            String str = words[i];
            if (str.length() != n)
                continue;

            boolean flag = true;
            for (int j = 0; j < n; j++) {

                int a = pattern.charAt(j) - 'a';
                char c = str.charAt(j);

                if (freq[a] == 0 && !set.contains(c)) {
                    freq[a] = c;
                    set.add(c);
                } else if (freq[a] != c) {
                    flag = false;
                    break;
                }
            }

            if (flag) list.add(str);
        }
        return list;
    }
}