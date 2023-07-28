impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut m = 0;
        let mut n = 0;
        let mut i = 0;
        let mut j = 0;
        let mut up = true;
        let mut max = 0;
        for row in nums.iter() {
            max += row.len();
        }
        while res.len() < max {
            res.push(nums[i][j]);
            if up {
                if i == 0 {
                    if j == nums[i].len() - 1 {
                        i += 1;
                    } else {
                        j += 1;
                    }
                    up = false;
                } else if j == nums[i].len() - 1 {
                    i += 1;
                    up = false;
                } else {
                    i -= 1;
                    j += 1;
                }
            } else {
                if j == 0 {
                    if i == nums.len() - 1 {
                        j += 1;
                    } else {
                        i += 1;
                    }
                    up = true;
                } else if i == nums.len() - 1 {
                    j += 1;
                    up = true;
                } else {
                    i += 1;
                    j -= 1;
                }
            }
        }
        res
    }
}