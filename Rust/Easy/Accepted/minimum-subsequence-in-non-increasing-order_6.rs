impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_by(|a, b| b.cmp(a));
        let mut ret = Vec::new();
        let mut sum = nums.iter().sum::<i32>();
        let mut temp = 0;
        for i in nums {
            ret.push(i);
            temp += i;
            sum -= i;
            if temp > sum {
                break;
            }
        }
        ret
    }
}