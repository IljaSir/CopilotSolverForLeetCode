impl Solution {
    pub fn maximize_xor(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut queries = queries;
        let mut result = Vec::new();
        nums.sort();
        for i in queries {
            let (x, m) = (i[0], i[1]);
            let mut max = -1;
            for j in nums.iter() {
                if j > &m {
                    break;
                }
                max = max.max(j ^ x);
            }
            result.push(max);
        }
        result
    }
}