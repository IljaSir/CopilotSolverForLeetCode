impl Solution {
    pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
        
        let mut result = 0;
        let mut subarray = Vec::new();
        for num in nums {
            if num % 2 == 0 {
                subarray.push(0);
            } else {
                subarray.push(1);
                result += 1;
            }
        }
        let mut i = 0;
        let mut j = 1;
        while j < subarray.len() {
            if subarray[i] == 0 && subarray[j] == 1 {
                result += 1;
                j += 1;
            } else if subarray[i] == 1 && subarray[j] == 1 {
                result += 1;
                i = j;
                j += 1;
            } else if subarray[i] == 1 && subarray[j] == 0 {
                i = j;
                j += 1;
            } else if subarray[i] == 0 && subarray[j] == 0 {
                j += 1;
            }
        }
        result as i64
    }
}