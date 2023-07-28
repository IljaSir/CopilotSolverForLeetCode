impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut m = vec![vec![]; n as usize];
        for (i, &v) in manager.iter().enumerate() {
            if v >= 0 {
                m[v as usize].push(i as i32);
            }
        }
        let mut q = std::collections::VecDeque::new();
        q.push_back((head_id, 0));
        while let Some((id, time)) = q.pop_front() {
            ans = ans.max(time);
            for &v in &m[id as usize] {
                q.push_back((v, time + inform_time[id as usize]));
            }
        }
        ans
    }
}