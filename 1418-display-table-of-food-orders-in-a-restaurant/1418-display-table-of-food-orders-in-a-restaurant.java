class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {         
        //KeyValuePair(map) ItemName as Key and Quantity as Value
        Map<String,Integer> itemNameQuantity; 

        //To get all the unique foodItem
        Set<String>foodItem = new TreeSet(); 

        // Actual Map to contain TableNumber as Key as first output column and the values would be rest output column. 
        //Values of the map would be another map with key as ItemName and ItemQuantiy as Values (Refer first line of code)
        TreeMap<Integer,Map<String,Integer>> map = new TreeMap();

        //Local Variables 
        int tableNumber = 0;
        String item="item";
        
        //Input processing from here
        for(List<String> list: orders){
            //Get the table number from first column of each row of input list
            tableNumber = Integer.parseInt(list.get(1));

            itemNameQuantity = map.get(tableNumber);
            //System.out.println("Temp:"+temp);
            if(itemNameQuantity == null){
                itemNameQuantity = new TreeMap();
                itemNameQuantity.put(list.get(2),1);
                foodItem.add(list.get(2));
            }
            else{
                item = list.get(2);
                foodItem.add(item);
                itemNameQuantity.put(item,itemNameQuantity.containsKey(item)?1+itemNameQuantity.get(item):1);
            }
            map.put(tableNumber,itemNameQuantity);  
        }

        //Now process from here for the output
        List<List<String>> result = new ArrayList(); //Required output type
        
        //Local List to be added in result list
        List<String> cur = new ArrayList();

        //Below line is used to add the header in output list
        cur.add("Table");

        //Now add all the fooditem name
        for(String s:foodItem) cur.add(s);
        result.add(cur);
        
        //Now get all the table items and quantity from the processed actual map
        for(int tableNum:map.keySet()){ //Why, since major map has key as table number and we have tableNumber as first column in the output list 
            cur = new ArrayList();
            cur.add(tableNum+""); //Add First Column

            itemNameQuantity = map.get(tableNum);
            
            //Now process each of the food item name and their quantity for given table number
            for(String s:foodItem){
                cur.add(itemNameQuantity.containsKey(s)?""+itemNameQuantity.get(s):"0");
            }
            //Add the each row into result list
            result.add(cur);

        }

        //Return the result list
        return result;
        
    }
}
