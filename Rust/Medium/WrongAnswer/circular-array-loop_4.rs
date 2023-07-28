impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let mut i = 0;
        let mut visited = vec![false; nums.len()];
        while i < nums.len() {
            if visited[i] {
                return true;
            }
            visited[i] = true;
            i = Self::next(nums[i], i, nums.len());
        }
        false
    }
    fn next(n: i32, i: usize, len: usize) -> usize {
        let next = i as i32 + n;
        if next >= 0 {
            (next as usize) % len
        } else {
            len - (-next as usize) % len
        }
    }
}