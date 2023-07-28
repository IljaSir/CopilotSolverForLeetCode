impl Solution {
    pub fn reconstruct_queue(people: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut people = people;
        people.sort_by(|a, b| b[0].cmp(&a[0]).then(a[1].cmp(&b[1])));
        let mut res = Vec::new();
        for p in people {
            res.insert(p[1] as usize, p);
        }
        res
    }
}