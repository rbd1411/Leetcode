class Solution {
    static void domain_visit(String s,HashMap<String,Integer> hm) {    
        int visit_cnt = Integer.valueOf(s.substring(0,s.indexOf(" ")));
        String new_str = s.substring(s.indexOf(" ")+1,s.length());
        List<Integer> al = new ArrayList<>();al.add(-1);
	for(int i=0;i<new_str.length();++i) {
		if(new_str.charAt(i)=='.') al.add(i);
	}
	   for (int it:al) {
            String res = (new_str.substring(it+1,new_str.length()));
            hm.put(res,hm.getOrDefault(res,0)+visit_cnt);
       }
    }
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> hm = new  HashMap<>();
        for (String str:cpdomains) {
            domain_visit(str,hm);
        }
        List<String> root_domains = new ArrayList<>();
        for (String res : hm.keySet()) {
            int x = hm.get(res);
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(x));sb.append(" ");sb.append(res);
            root_domains.add(sb.toString());
        }
        return(root_domains);
    }
}