impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_unstable();
        let sum = nums.iter().sum::<i32>();
        let mut res = vec![];
        let mut cur_sum = 0;
        while cur_sum <= sum / 2 {
            let num = nums.pop().unwrap();
            cur_sum += num;
            res.push(num);
        }
        res
    }
}