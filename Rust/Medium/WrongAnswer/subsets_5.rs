impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut current: Vec<i32> = Vec::new();
        result.push(current.clone());
        for i in 0..nums.len() {
            let mut j = i;
            while j < nums.len() {
                current.push(nums[j]);
                result.push(current.clone());
                j += 1;
            }
            current = Vec::new();
        }
        result
    }
}