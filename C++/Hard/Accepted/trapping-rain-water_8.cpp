class Solution {
public:
    int trap(vector<int>& height) {
        
        int n = height.size();
        if(n == 0) return 0;
        int left = 0, right = n-1;
        int leftmax = height[left], rightmax = height[right];
        int res = 0;
        while(left < right) {
            leftmax = max(leftmax, height[left]);
            rightmax = max(rightmax, height[right]);
            if(leftmax < rightmax) {
                res += leftmax - height[left];
                left++;
            } else {
                res += rightmax - height[right];
                right--;
            }
        }
        return res;
    }
};