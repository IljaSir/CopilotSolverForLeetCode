impl Solution {
    pub fn max_kelements(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        let mut k = k;
        let mut sum = 0;
        let mut heap = BinaryHeap::new();
        for n in nums.iter() {
            sum += *n as i64;
            heap.push(*n);
        }
        while k > 0 {
            let n = heap.pop().unwrap();
            sum -= n as i64;
            sum += (n / 3) as i64;
            heap.push(n / 3);
            k -= 1;
        }
        sum
    }
}