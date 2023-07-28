impl Solution {
    pub fn watched_videos_by_friends(watched_videos: Vec<Vec<String>>, friends: Vec<Vec<i32>>, id: i32, level: i32) -> Vec<String> {
        
        let n = watched_videos.len();
        let mut friends = friends;
        let mut visited = vec![false; n];
        let mut q = vec![(id, 0)];
        let mut res = vec![];
        while !q.is_empty() {
            let (v, l) = q.remove(0);
            if visited[v as usize] {
                continue;
            }
            visited[v as usize] = true;
            if l == level {
                res = watched_videos[v as usize].clone();
                break;
            }
            for &f in friends[v as usize].iter() {
                q.push((f, l+1));
            }
        }
        let mut map = std::collections::HashMap::new();
        for v in res.iter() {
            *map.entry(v).or_insert(0) += 1;
        }
        let mut res = map.into_iter().collect::<Vec<_>>();
        res.sort_by(|&a, &b| {
            if a.1 == b.1 {
                a.0.cmp(b.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        res.into_iter().map(|(k, _)| k.to_string()).collect()
    }
}