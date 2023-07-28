impl Solution {
    pub fn closest_room(rooms: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut rooms = rooms;
        let mut queries = queries;
        let mut result = vec![];
        let mut ids = vec![];
        for i in 0..queries.len() {
            ids.push(i);
        }
        rooms.sort_by(|a, b| {
            a[1].cmp(&b[1])
        });
        queries.sort_by(|a, b| {
            b[1].cmp(&a[1])
        });
        let mut j = 0;
        let mut tree = std::collections::BTreeSet::new();
        for i in 0..queries.len() {
            let q = &queries[i];
            while j < rooms.len() && rooms[j][1] >= q[1] {
                tree.insert(rooms[j][0]);
                j += 1;
            }
            if tree.is_empty() {
                result.push(-1);
            } else {
                let id = ids[i];
                let p = queries[id][0];
                let it = tree.range(p..=p);
                if let Some(x) = it.next() {
                    result.push(*x);
                } else {
                    let it = tree.range(..p);
                    let x = it.next_back().unwrap();
                    result.push(*x);
                }
            }
        }
        result
    }
}