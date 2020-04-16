import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        //保证stack中对应的位置在height中递增。
        Stack<Integer> stack = new Stack<>();
        int maxValue = 0;
        int width;
        int top;
        for (int i = 0; i < heights.length; i++) {
            //因为stack是递增的，因此比栈顶大的话可以直接入栈
            if (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                //不然的话就出栈，算出以当前值为结尾的情况下的面积
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    top = stack.pop();
                    if (stack.empty()) {
                        width = i;
                    } else {
                        width = i - stack.peek() - 1;   //i是右边能到达的位置，stack.peek()是左边的位置，因此宽度为i-stack.peek()-1
                    }


                    maxValue = Math.max(maxValue, (width) * heights[top]);
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            top = stack.pop();
            if(stack.empty()){
                width = heights.length;
            }else {
                width = heights.length-stack.peek()-1;
            }
            maxValue = Math.max(maxValue,width*heights[top]);
        }
        return maxValue;
    }
}
