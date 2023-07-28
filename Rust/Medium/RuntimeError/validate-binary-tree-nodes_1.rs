impl Solution {
    pub fn validate_binary_tree_nodes(n: i32, left_child: Vec<i32>, right_child: Vec<i32>) -> bool {
        
        let n = n as usize;
        let mut indegree = vec![0; n];
        let mut outdegree = vec![0; n];
        let mut queue = std::collections::VecDeque::new();
        for i in 0..n {
            outdegree[i] += if left_child[i] != -1 { 1 } else { 0 };
            outdegree[i] += if right_child[i] != -1 { 1 } else { 0 };
            indegree[left_child[i] as usize] += if left_child[i] != -1 { 1 } else { 0 };
            indegree[right_child[i] as usize] += if right_child[i] != -1 { 1 } else { 0 };
        }
        for i in 0..n {
            if indegree[i] == 0 {
                queue.push_back(i);
            }
        }
        let mut cnt = 0;
        while let Some(u) = queue.pop_front() {
            cnt += 1;
            if left_child[u] != -1 {
                queue.push_back(left_child[u] as usize);
            }
            if right_child[u] != -1 {
                queue.push_back(right_child[u] as usize);
            }
        }
        cnt == n && indegree.iter().all(|&x| x <= 1) && outdegree.iter().all(|&x| x <= 2)
    }
}