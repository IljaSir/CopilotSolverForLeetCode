impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut temp: Vec<i32> = Vec::new();
        result.push(temp.clone());
        for i in 0..nums.len() {
            temp.push(nums[i]);
            result.push(temp.clone());
            for j in i+1..nums.len() {
                temp.push(nums[j]);
                result.push(temp.clone());
                temp.pop();
            }
            temp.pop();
        }
        result
    }
}