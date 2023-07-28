impl Solution {
    pub fn maximize_xor(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut queries = queries;
        let mut answer = Vec::new();
        nums.sort();
        for i in 0..queries.len() {
            let mut max = -1;
            for j in 0..nums.len() {
                if nums[j] > queries[i][1] {
                    break;
                }
                max = max.max(nums[j] ^ queries[i][0]);
            }
            answer.push(max);
        }
        answer
    }
}