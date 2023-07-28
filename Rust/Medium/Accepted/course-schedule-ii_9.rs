impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut pre_count = vec![0; num_courses as usize];
        let mut edges = vec![vec![]; num_courses as usize];
        for pre in &prerequisites {
            pre_count[pre[0] as usize] += 1;
            edges[pre[1] as usize].push(pre[0]);
        }
        let mut q = Vec::new();
        for i in 0..num_courses {
            if pre_count[i as usize] == 0 {
                q.push(i);
            }
        }
        let mut ans = Vec::new();
        while !q.is_empty() {
            let i = q.remove(0);
            ans.push(i);
            for &j in &edges[i as usize] {
                pre_count[j as usize] -= 1;
                if pre_count[j as usize] == 0 {
                    q.push(j);
                }
            }
        }
        if ans.len() == num_courses as usize {
            ans
        } else {
            vec![]
        }
    }
}