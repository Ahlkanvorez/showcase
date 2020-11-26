# Showcase

A personal showcase website designed to highlight the things I love
working on by linking to live demos or source code of some of my
projects, sharing short thoughts in my blog, and outlining the
technologies I've worked with.

The server is written in Clojure using Ring & Compojure, and the front
end is static HTML generated via Hiccup, styled using Bootstrap. The
project descriptions live in an EDN file in a separate repository, as
do the blog articles, so that I can quickly add, edit, or remove them
without having to recompile or redeploy any source code.

Deployments are to Heroku.

## Usage

The project setup assumes you have [Leiningen](https://leiningen.org/)
installed.

- Set environment varialbes ARTICLES_REPO & PROJECTS_REPO; defaults:
```
ARTICLES_REPO: https://bitbucket.org/ahlk/blog/raw/master/
PROJECTS_REPO: https://bitbucket.org/ahlk/project-showcase/raw/master/
```
- Run `lein run` in your terminal
- Wait until you see `[main] INFO org.eclipse.jetty.server.Server - Started`
- Open [localhost:3000](http://localhost:3000) in your browser.

An alternate port can be used by setting the environment varialbe `PORT`
to the desired value before starting the server.

## Deployment

The server is deployed to Heroku, which merely involves pushing commits
to the heroku remote.

## License

BSD 3-Clause License

Copyright (c) 2020, Robert Mitchell
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.