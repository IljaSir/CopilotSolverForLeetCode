impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        
        let mut paths = paths;
        let mut start = paths[0][0].clone();
        let mut end = paths[0][1].clone();
        paths.remove(0);
        while paths.len() > 0 {
            let mut i = 0;
            while i < paths.len() {
                if paths[i][0] == start {
                    start = paths[i][1].clone();
                    paths.remove(i);
                    break;
                } else if paths[i][0] == end {
                    end = paths[i][1].clone();
                    paths.remove(i);
                    break;
                } else if paths[i][1] == start {
                    start = paths[i][0].clone();
                    paths.remove(i);
                    break;
                } else if paths[i][1] == end {
                    end = paths[i][0].clone();
                    paths.remove(i);
                    break;
                } else {
                    i += 1;
                }
            }
        }
        end
    }
}