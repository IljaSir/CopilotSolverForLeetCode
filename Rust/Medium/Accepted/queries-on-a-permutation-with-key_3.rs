impl Solution {
    pub fn process_queries(queries: Vec<i32>, m: i32) -> Vec<i32> {
        
        let mut p: Vec<i32> = (1..=m).collect();
        let mut res = Vec::new();
        for i in queries {
            let pos = p.iter().position(|&x| x == i).unwrap();
            res.push(pos as i32);
            p.remove(pos);
            p.insert(0, i);
        }
        res
    }
}