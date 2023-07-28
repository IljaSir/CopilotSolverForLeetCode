impl Solution {
    pub fn process_queries(queries: Vec<i32>, m: i32) -> Vec<i32> {
        
        let mut p: Vec<i32> = (1..=m).collect();
        let mut res: Vec<i32> = Vec::new();
        for q in queries {
            let i = p.iter().position(|&x| x == q).unwrap();
            res.push(i as i32);
            p.remove(i);
            p.insert(0, q);
        }
        res
    }
}