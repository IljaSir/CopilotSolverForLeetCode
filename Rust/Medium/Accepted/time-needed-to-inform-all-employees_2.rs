impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut tree: Vec<Vec<i32>> = vec![vec![]; n as usize];
        for i in 0..n as usize {
            if manager[i] != -1 {
                tree[manager[i] as usize].push(i as i32);
            }
        }
        let mut ans = 0;
        let mut q: Vec<(i32, i32)> = vec![];
        q.push((head_id, 0));
        while !q.is_empty() {
            let (i, t) = q.remove(0);
            ans = ans.max(t);
            for &j in tree[i as usize].iter() {
                q.push((j, t + inform_time[i as usize]));
            }
        }
        ans
    }
}