class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        return canMeasureWater(x, y, x, y, target, new HashSet<>());
    }

    public boolean canMeasureWater(int x, int y, int xCapacity, int yCapacity, int target, Set<String> visited) {
        String key = getKey(x, y);
        if(visited.contains(key)) {
            return false;
        }
        visited.add(key);
        if(x == target || y == target || x + y == target) {
            return true;
        }
        return canMeasureWater(0, y, xCapacity, yCapacity, target, visited) 
            || canMeasureWater(x, 0, xCapacity, yCapacity, target, visited)
            || canMeasureWater(xCapacity, y, xCapacity, yCapacity, target, visited)
            || canMeasureWater(x, yCapacity, xCapacity, yCapacity, target, visited)
            || canMeasureWater(Math.max(0, x - (yCapacity-y)), Math.min(x+y, yCapacity), xCapacity, yCapacity, target, visited)
            || canMeasureWater(Math.min(x+y, xCapacity), Math.max(0, y - (xCapacity-x)), xCapacity, yCapacity, target, visited);
        
    }

    private String getKey(int x, int y) {
        return new StringBuilder().append(x).append("-").append(y).toString();
    }
}