class Trie{
    Map<String,Trie> children;
    String signature;
    Trie(){
        children = new HashMap<>();
        signature = "";
    }
}
class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie root = new Trie();

        //Building trie
        for(List<String> path : paths){
            Trie curr = root;
            for(String p : path)
                curr = curr.children.computeIfAbsent(p, k -> new Trie());
        }

        //Time to formulate all signatures , and keep a track of it using a hashmap
        Map<String,Integer> map = new HashMap<>();

        dfs(root,map);

        //Now remove the folders marked as duplicates
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        removeDup(root,map,path,ans);

        return ans;
    }

    private void removeDup(
        Trie root,
        Map<String,Integer> map,
        List<String> path,
        List<List<String>> ans
    ){
        if(map.getOrDefault(root.signature,0) > 1)
            return;
        
        if(!path.isEmpty())
            ans.add(new ArrayList<>(path));
        
        for(String child : root.children.keySet()){
            Trie childChildren = root.children.get(child);
            path.add(child);
            removeDup(childChildren,map,path,ans);
            path.remove(path.size()-1);
        }
    }

    private void dfs(Trie root,Map<String,Integer> map){
        if(root.children.isEmpty())
            return;
        
        List<String> list = new ArrayList<>();
        for(String child : root.children.keySet()){
            Trie childChildren = root.children.get(child);
            dfs(childChildren,map);
            list.add(child+"("+childChildren.signature+")");
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for(String s : list)
            sb.append(s);

        String sig = sb.toString();
        root.signature = sig;
        map.put(sig,map.getOrDefault(sig,0)+1);
    }
}