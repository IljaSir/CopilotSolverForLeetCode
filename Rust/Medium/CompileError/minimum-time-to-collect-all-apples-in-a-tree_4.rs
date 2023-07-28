impl Solution {
    pub fn min_time(n: i32, edges: Vec<Vec<i32>>, has_apple: Vec<bool>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for e in edges {
            map.entry(e[0]).or_insert(vec![]).push(e[1]);
            map.entry(e[1]).or_insert(vec![]).push(e[0]);
        }
        let mut visited = vec![false; n as usize];
        Self::dfs(0, &mut map, &mut visited, &has_apple) * 2
    }
    fn dfs(node: i32, map: &mut std::collections::HashMap<i32, Vec<i32>>, visited: &mut Vec<bool>, has_apple: &Vec<bool>) -> i32 {
        if visited[node as usize] {
            return 0;
        }
        visited[node as usize] = true;
        let mut ret = 0;
        for &n in map.get(&node).unwrap() {
            ret += Self::dfs(n, map, visited, has_apple);
        }
        if ret > 0 || has_apple[node as usize] {
            ret += 1;
        }
        ret
    }
}