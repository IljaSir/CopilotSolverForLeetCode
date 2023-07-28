impl Solution {
    pub fn maximize_xor(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut queries = queries;
        nums.sort();
        for i in 0..queries.len() {
            let mut res = -1;
            for j in 0..nums.len() {
                if nums[j] > queries[i][1] {
                    break;
                }
                res = res.max(nums[j] ^ queries[i][0]);
            }
            queries[i][0] = res;
        }
        queries.iter().map(|i| i[0]).collect()
    }
}