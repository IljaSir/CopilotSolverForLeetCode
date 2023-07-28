impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let mut visited = vec![0; nums.len()];
        let mut next = |i: usize| {
            let n = nums.len() as i32;
            ((i as i32 + nums[i]) % n + n) as usize % n as usize
        };
        for i in 0..nums.len() {
            if visited[i] != 0 {
                continue;
            }
            let mut slow = i;
            let mut fast = i;
            let mut d = 1;
            while visited[slow] == 0 && visited[fast] == 0 {
                visited[slow] = d;
                slow = next(slow);
                d += 1;
                visited[fast] = d;
                fast = next(fast);
                d += 1;
                visited[fast] = d;
                fast = next(fast);
                d += 1;
            }
            if visited[slow] > 0 && visited[slow] % 2 == 0 && visited[slow] / 2 == visited[fast] {
                return true;
            }
        }
        false
    }
}