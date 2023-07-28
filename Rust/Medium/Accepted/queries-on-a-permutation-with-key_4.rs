impl Solution {
    pub fn process_queries(queries: Vec<i32>, m: i32) -> Vec<i32> {
        
        let mut p = (1..=m).collect::<Vec<i32>>();
        let mut res = Vec::new();
        for i in queries {
            let index = p.iter().position(|&x| x == i).unwrap();
            res.push(index as i32);
            p.remove(index);
            p.insert(0, i);
        }
        res
    }
}