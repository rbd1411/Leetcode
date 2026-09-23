class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String signature = new String(chars);

            groups.putIfAbsent(signature, new ArrayList<>());
            groups.get(signature).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}