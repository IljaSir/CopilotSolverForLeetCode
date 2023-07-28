impl Solution {
    pub fn calc_equation(equations: Vec<Vec<String>>, values: Vec<f64>, queries: Vec<Vec<String>>) -> Vec<f64> {
        

        let mut graph = std::collections::HashMap::new();
        for (i, eq) in equations.iter().enumerate() {
            let (a, b) = (eq[0].clone(), eq[1].clone());
            let val = values[i];
            graph.entry(a.clone()).or_insert(std::collections::HashMap::new()).insert(b.clone(), val);
            graph.entry(b.clone()).or_insert(std::collections::HashMap::new()).insert(a.clone(), 1.0 / val);
        }
        queries.iter().map(|q| {
            let (a, b) = (q[0].clone(), q[1].clone());
            if a == b {
                return 1.0;
            }
            if !graph.contains_key(&a) || !graph.contains_key(&b) {
                return -1.0;
            }
            let mut visited = std::collections::HashSet::new();
            Self::dfs(&graph, &mut visited, &a, &b, 1.0)
        }).collect()
    }
    fn dfs(graph: &std::collections::HashMap<String, std::collections::HashMap<String, f64>>, visited: &mut std::collections::HashSet<String>, a: &String, b: &String, val: f64) -> f64 {
        if a == b {
            return val;
        }
        visited.insert(a.clone());
        for (k, v) in graph.get(a).unwrap() {
            if visited.contains(k) {
                continue;
            }
            let ret = Self::dfs(graph, visited, k, b, val * v);
            if ret != -1.0 {
                return ret;
            }
        }
        -1.0
    }
}