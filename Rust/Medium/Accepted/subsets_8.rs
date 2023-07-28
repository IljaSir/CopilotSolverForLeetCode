impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        result.push(Vec::new());
        for i in 0..nums.len() {
            let mut j = 0;
            let mut new_result = Vec::new();
            while j < result.len() {
                let mut new_vec = result[j].clone();
                new_vec.push(nums[i]);
                new_result.push(new_vec);
                j += 1;
            }
            result.append(&mut new_result);
        }
        result
    }
}