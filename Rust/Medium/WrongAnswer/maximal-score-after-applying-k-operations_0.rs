impl Solution {
    pub fn max_kelements(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        let mut k = k as usize;
        let mut heap = std::collections::BinaryHeap::new();
        for &num in &nums {
            heap.push(num);
        }
        while k > 0 {
            let top = heap.pop().unwrap();
            if top == 1 {
                break;
            }
            heap.push(top / 3);
            k -= 1;
        }
        heap.iter().map(|&x| x as i64).sum()
    }
}