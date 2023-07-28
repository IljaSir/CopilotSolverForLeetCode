impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let k = k as usize;
        let mut sorted: Vec<i32> = nums.iter().take(k).cloned().collect();
        sorted.sort();
        let mut sum = sorted.iter().take(k-1).sum::<i32>() as i64;
        let mut i = k-1;
        for num in nums.iter().skip(k) {
            let idx = sorted.binary_search(num).unwrap_or_else(|x| x);
            if idx < k-1 {
                sum += sorted[k-1] as i64;
                sorted.remove(k-1);
                sorted.insert(idx, *num);
            } else {
                sum += *num as i64;
            }
            i += 1;
        }
        sum
    }
}