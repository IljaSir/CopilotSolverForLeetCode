impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = vec![];
        let mut m = nums.len();
        let mut n = 0;
        for i in 0..m {
            n = n.max(nums[i].len());
        }
        for i in 0..m+n-1 {
            for j in 0..i+1 {
                if j >= m || i-j >= n {
                    continue;
                }
                result.push(nums[j][i-j]);
            }
        }
        result
    }
}