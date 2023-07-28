impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut i = 0;
        let mut j = 0;
        let mut is_up = true;
        let mut m = nums.len();
        let mut n = 0;
        for row in nums.iter() {
            n = n.max(row.len());
        }
        while m > 0 && n > 0 {
            res.push(nums[i][j]);
            if is_up {
                if j == n - 1 {
                    i += 1;
                    is_up = false;
                } else if i == 0 {
                    j += 1;
                    is_up = false;
                } else {
                    i -= 1;
                    j += 1;
                }
            } else {
                if i == m - 1 {
                    j += 1;
                    is_up = true;
                } else if j == 0 {
                    i += 1;
                    is_up = true;
                } else {
                    i += 1;
                    j -= 1;
                }
            }
            if i >= m || j >= n {
                break;
            }
        }
        res
    }
}