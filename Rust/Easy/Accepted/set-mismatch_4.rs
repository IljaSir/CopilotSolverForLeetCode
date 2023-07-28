impl Solution {
    pub fn find_error_nums(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut count = vec![0; n + 1];
        for x in nums {
            count[x as usize] += 1;
        }
        let mut ans = vec![0; 2];
        for i in 1..=n {
            if count[i] == 2 {
                ans[0] = i as i32;
            } else if count[i] == 0 {
                ans[1] = i as i32;
            }
        }
        ans
    }
}