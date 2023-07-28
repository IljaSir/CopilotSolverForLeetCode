impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut diag = Vec::new();
        let mut m = nums.len();
        let mut n = 0;
        for i in 0..m {
            if n < nums[i].len() {
                n = nums[i].len();
            }
        }
        for i in 0..m+n-1 {
            diag.clear();
            for j in 0..m {
                if i < nums[j].len() {
                    diag.push(nums[j][i]);
                }
            }
            if i % 2 == 0 {
                diag.reverse();
            }
            ans.append(&mut diag);
        }
        ans
    }
}