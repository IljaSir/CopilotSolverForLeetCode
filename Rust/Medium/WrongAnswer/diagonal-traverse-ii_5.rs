impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut max = 0;
        for i in 0..nums.len() {
            for j in 0..nums[i].len() {
                if i + j > max {
                    max = i + j;
                }
            }
        }
        for i in 0..=max {
            let mut temp = Vec::new();
            for j in 0..nums.len() {
                if i >= j && i - j < nums[j].len() {
                    temp.push(nums[j][i - j]);
                }
            }
            if i % 2 == 0 {
                temp.reverse();
            }
            result.append(&mut temp);
        }
        result
    }
}