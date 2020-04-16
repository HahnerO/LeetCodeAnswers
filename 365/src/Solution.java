public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == z || y == z || x + y <= z){
            return x + y >= z;
        }
        return x > y ? ( z % gcd(x, y)) == 0 : (z % gcd(y, x)) == 0;
    }
    public int gcd(int x,int y){
        return y == 0 ? x : gcd(y, x % y);
    }
}
